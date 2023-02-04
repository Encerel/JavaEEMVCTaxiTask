package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.command.Router;
import by.bsac.taxi.model.dao.impl.TaxiDaoImpl;
import by.bsac.taxi.model.service.TaxiService;
import by.bsac.taxi.model.service.impl.TaxiServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CalculateCostTaxisCommand implements Command {

    private TaxiService taxiService = new TaxiServiceImpl(new TaxiDaoImpl());

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router = new Router();
        String currentPage = (String) session.getAttribute(ParametersAndAttribute.CURRENT_PAGE);
        router.setPagePath(currentPage);
        double taxisCost = taxiService.calculateCostTaxis();
        session.setAttribute(ParametersAndAttribute.TAXIS_COST, taxisCost);
        return router;
    }
}
