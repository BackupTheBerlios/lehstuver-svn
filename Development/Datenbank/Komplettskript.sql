--
-- PostgreSQL database dump
--

SET client_encoding = 'LATIN1';
SET check_function_bodies = false;

SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 4 (OID 2200)
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


SET SESSION AUTHORIZATION 'markus';

SET search_path = public, pg_catalog;

--
-- TOC entry 5 (OID 26168)
-- Name: tbl_lehrer; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_lehrer (
    lehrerid serial NOT NULL,
    vorname text,
    nachname text,
    gebdatum date
);


--
-- TOC entry 6 (OID 26176)
-- Name: tbl_fachbereiche; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_fachbereiche (
    fachbereichid serial NOT NULL,
    name text
);


--
-- TOC entry 7 (OID 26184)
-- Name: tbl_altersteilzeit; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_altersteilzeit (
    altersteilzeitid serial NOT NULL,
    bezeichnung text,
    "alter" numeric,
    wochenstunden numeric,
    stichtag date
);


--
-- TOC entry 8 (OID 26192)
-- Name: tbl_entlastungsstunden; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_entlastungsstunden (
    entlastungsstundenid serial NOT NULL,
    bezeichnung text,
    grund text,
    gesetzlich boolean,
    wochenstunden numeric
);


--
-- TOC entry 9 (OID 26198)
-- Name: tbl_lehrerfachbereich; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_lehrerfachbereich (
    lehrerid integer NOT NULL,
    fachbereichid integer NOT NULL,
    halbjahr character varying(6) NOT NULL,
    wochenstunden integer
);


--
-- TOC entry 10 (OID 26200)
-- Name: tbl_lehrerentlastungsstunden; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_lehrerentlastungsstunden (
    lehrerid integer NOT NULL,
    entlastungsstundenid integer NOT NULL,
    halbjahr character varying(6)
);


--
-- TOC entry 11 (OID 26236)
-- Name: tbl_lehrerstatus; Type: TABLE; Schema: public; Owner: markus
--

CREATE TABLE tbl_lehrerstatus (
    lehrerid integer NOT NULL,
    habljahr character varying(6) NOT NULL,
    "status_bsa " character varying(5),
    status_lbf character varying(5),
    status_rv character varying(5)
);


--
-- TOC entry 14 (OID 26208)
-- Name: PK_Altersteilzeit; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_altersteilzeit
    ADD CONSTRAINT "PK_Altersteilzeit" PRIMARY KEY (altersteilzeitid);


--
-- TOC entry 15 (OID 26210)
-- Name: PK_Entlastungsstunden; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_entlastungsstunden
    ADD CONSTRAINT "PK_Entlastungsstunden" PRIMARY KEY (entlastungsstundenid);


--
-- TOC entry 13 (OID 26212)
-- Name: PK_Fachbereiche; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_fachbereiche
    ADD CONSTRAINT "PK_Fachbereiche" PRIMARY KEY (fachbereichid);


--
-- TOC entry 12 (OID 26214)
-- Name: PK_Lehrer; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrer
    ADD CONSTRAINT "PK_Lehrer" PRIMARY KEY (lehrerid);


--
-- TOC entry 17 (OID 26216)
-- Name: PK_LehrerEntlastungsstunden; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerentlastungsstunden
    ADD CONSTRAINT "PK_LehrerEntlastungsstunden" PRIMARY KEY (lehrerid, entlastungsstundenid);


--
-- TOC entry 16 (OID 26226)
-- Name: PK_LehrerFachbereich; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerfachbereich
    ADD CONSTRAINT "PK_LehrerFachbereich" PRIMARY KEY (lehrerid, fachbereichid, halbjahr);


--
-- TOC entry 18 (OID 26238)
-- Name: PK_Lehrerstatus; Type: CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerstatus
    ADD CONSTRAINT "PK_Lehrerstatus" PRIMARY KEY (lehrerid, habljahr);


--
-- TOC entry 21 (OID 26218)
-- Name: FK_Lehrerentlastungsstunden_Entlastungsstunden; Type: FK CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerentlastungsstunden
    ADD CONSTRAINT "FK_Lehrerentlastungsstunden_Entlastungsstunden" FOREIGN KEY (entlastungsstundenid) REFERENCES tbl_entlastungsstunden(entlastungsstundenid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 22 (OID 26222)
-- Name: FK_Lehrerentlastungsstunden_Lehrer; Type: FK CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerentlastungsstunden
    ADD CONSTRAINT "FK_Lehrerentlastungsstunden_Lehrer" FOREIGN KEY (lehrerid) REFERENCES tbl_lehrer(lehrerid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 19 (OID 26228)
-- Name: FK_Lehrerfachbereich_Lehrer; Type: FK CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerfachbereich
    ADD CONSTRAINT "FK_Lehrerfachbereich_Lehrer" FOREIGN KEY (lehrerid) REFERENCES tbl_lehrer(lehrerid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 20 (OID 26232)
-- Name: FK_Lehrerfachbereich_Fachbereich; Type: FK CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerfachbereich
    ADD CONSTRAINT "FK_Lehrerfachbereich_Fachbereich" FOREIGN KEY (fachbereichid) REFERENCES tbl_fachbereiche(fachbereichid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 23 (OID 26240)
-- Name: FK_Lehrerstatus_Lehrer; Type: FK CONSTRAINT; Schema: public; Owner: markus
--

ALTER TABLE ONLY tbl_lehrerstatus
    ADD CONSTRAINT "FK_Lehrerstatus_Lehrer" FOREIGN KEY (lehrerid) REFERENCES tbl_lehrer(lehrerid) ON UPDATE CASCADE ON DELETE CASCADE;


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 3 (OID 2200)
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';