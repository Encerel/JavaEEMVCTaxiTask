PGDMP     1                    {            taxi    14.5    14.5     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    57904    taxi    DATABASE     h   CREATE DATABASE taxi WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1251';
    DROP DATABASE taxi;
                postgres    false            ?           1247    57926 	   user_role    TYPE     B   CREATE TYPE public.user_role AS ENUM (
    'USER',
    'ADMIN'
);
    DROP TYPE public.user_role;
       public          postgres    false            ?            1259    57908    taxi    TABLE     ?   CREATE TABLE public.taxi (
    taxi_id bigint NOT NULL,
    model character varying NOT NULL,
    speed integer NOT NULL,
    fuel_consumption real NOT NULL,
    price real NOT NULL
);
    DROP TABLE public.taxi;
       public         heap    postgres    false            ?            1259    57931    taxi_taxi_id_seq    SEQUENCE     ?   ALTER TABLE public.taxi ALTER COLUMN taxi_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.taxi_taxi_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    57905    user    TABLE       CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    name character varying(100) NOT NULL,
    surname character varying(100) NOT NULL,
    email character varying(200) NOT NULL,
    password character varying NOT NULL,
    role public.user_role NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false    831            ?            1259    57911    user_user_id_seq    SEQUENCE     ?   ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            ?          0    57908    taxi 
   TABLE DATA           N   COPY public.taxi (taxi_id, model, speed, fuel_consumption, price) FROM stdin;
    public          postgres    false    210   U       ?          0    57905    user 
   TABLE DATA           O   COPY public."user" (user_id, name, surname, email, password, role) FROM stdin;
    public          postgres    false    209   ?       ?           0    0    taxi_taxi_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.taxi_taxi_id_seq', 3, true);
          public          postgres    false    212            ?           0    0    user_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_user_id_seq', 2, true);
          public          postgres    false    211            g           2606    57938    taxi taxi_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.taxi
    ADD CONSTRAINT taxi_pkey PRIMARY KEY (taxi_id);
 8   ALTER TABLE ONLY public.taxi DROP CONSTRAINT taxi_pkey;
       public            postgres    false    210            e           2606    57918    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    209            ?   N   x??!?0@}yE^?I??????X??nB?5?x?:?+L2?y&?????6)\s)??m?=`???(?t?s??      ?   u   x?3??,K??e??@?!713G????$?????<?$???????$?<???8?34?5?ː?1/?(5?321/;?,???3$PY	?W9??J?υ?djn??S?&8??z?q??qqq ?&?     