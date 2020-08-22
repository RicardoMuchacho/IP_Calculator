--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12
-- Dumped by pg_dump version 10.12

-- Started on 2020-08-22 01:01:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2800 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16604)
-- Name: ip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ip (
    ip_address character varying NOT NULL,
    priv_public character varying,
    clase character varying,
    apipa character varying,
    reservada character varying,
    uni_multi_broad character varying,
    network_address character varying,
    gateway character varying,
    broadcast character varying,
    rango character varying
);


ALTER TABLE public.ip OWNER TO postgres;

--
-- TOC entry 2792 (class 0 OID 16604)
-- Dependencies: 196
-- Data for Name: ip; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ip (ip_address, priv_public, clase, apipa, reservada, uni_multi_broad, network_address, gateway, broadcast, rango) FROM stdin;
168.55.55.5/24	Publica	Clase B	no pertenece	no reservada	Unicast	168.55.55.0	168.55.55.1	168.55.55.255	168.55.55.0 - 168.55.55.255
10.55.55.5/18	Privada	Clase A	no pertenece	no reservada	Unicast	10.55.0.0	10.55.0.1	10.55.63.255	10.55.0.0 - 10.55.63.255
168.1.1.1/24	Publica	Clase B	no pertenece	Reservada para Gateway	Unicast	168.1.1.0	168.1.1.1	168.1.1.255	168.1.1.0 - 168.1.1.255
100.1.1.1/24	Publica	Clase A	no pertenece	Reservada para Gateway	Unicast	100.1.1.0	100.1.1.1	100.1.1.255	100.1.1.0 - 100.1.1.255
10.1.1.1/24	Privada	Clase A	no pertenece	Reservada para Gateway	Unicast	10.1.1.0	10.1.1.1	10.1.1.255	10.1.1.0 - 10.1.1.255
10.1.1.1/0	Privada	Clase A	no pertenece	no reservada	Unicast	0.0.0.0	0.0.0.1	255.255.255.255	0.0.0.0 - 255.255.255.255
\.


--
-- TOC entry 2670 (class 2606 OID 16611)
-- Name: ip IP_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ip
    ADD CONSTRAINT "IP_pkey" PRIMARY KEY (ip_address);


-- Completed on 2020-08-22 01:01:10

--
-- PostgreSQL database dump complete
--

