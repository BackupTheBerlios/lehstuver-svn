
CREATE TABLE "tbl_Lehrerstatus"
(
"LehrerID" INTEGER,
"Halbjahr" varchar(6),
"Status_RV" varchar(2),
"Status_LBF" varchar(2),
"Status_BSA" varchar(2),
PRIMARY KEY("LehrerID","Halbjahr"),
FOREIGN KEY ("LehrerID") references "tbl_Lehrer"("LehrerID")
)



CREATE TABLE "tbl_Lehrerfachbereich"
(
"LehrerID" INTEGER,
"FachbereichID" INTEGER,
"Halbjahr" varchar(6),
"Wochenstunden" double,
PRIMARY KEY("LehrerID","FachbereichID","Halbjahr"),
FOREIGN KEY ("LehrerID") references "tbl_Lehrer"("LehrerID"),
FOREIGN KEY ("FachbereichID") references "tbl_Fachbereiche"("FachbereichID")
)


CREATE TABLE "tbl_LehrerEntlastungsstunden"
(
"LehrerID" INTEGER,
"EntlastungsstundenID" INTEGER,
"Halbjahr" varchar(6),
PRIMARY KEY("LehrerID","EntlastungsstundenID","Halbjahr"),
FOREIGN KEY ("LehrerID") references "tbl_Lehrer"("LehrerID"),
FOREIGN KEY ("EntlastungsstundenID") references "tbl_Entlastungsstunden"("EntlastungsstundenID")
)
