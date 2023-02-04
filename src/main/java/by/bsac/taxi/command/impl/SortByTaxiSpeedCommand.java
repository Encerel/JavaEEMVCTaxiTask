package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.command.Router;
import by.bsac.taxi.entity.Taxi;
import by.bsac.taxi.model.dao.impl.TaxiDaoImpl;
import by.bsac.taxi.model.service.TaxiService;
import by.bsac.taxi.model.service.impl.TaxiServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class SortByTaxiSpeedCommand implements Command {

    private TaxiService taxiService = new TaxiServiceImpl(new TaxiDaoImpl());

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(ParametersAndAttribute.CURRENT_PAGE);
        router.setPagePath(currentPage);
        int lowerSpeedRange = Integer.parseInt(request.getParameter(ParametersAndAttribute.LOWER_RANGE));
        int upperSpeedRange = Integer.parseInt(request.getParameter(ParametersAndAttribute.UPPER_RANGE));

        List<Taxi> taxis = taxiService.findAll().stream()
                .filter(taxi -> taxi.getSpeed() >= lowerSpeedRange && taxi.getSpeed() <=upperSpeedRange)
                .collect(Collectors.toList());

        session.setAttribute(ParametersAndAttribute.TAXI_LIST, taxis);
        return router;
    }
}
