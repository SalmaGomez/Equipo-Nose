CREATE TABLE Resultados (
  idResultados INTEGER NOT NULL AUTO_INCREMENT,
  Impuestos FLOAT NULL,
  Ganancias FLOAT NULL,
  Perdidas FLOAT NULL,
  Utilidad_Bruta FLOAT NULL,
  Fecha DATE NULL,
  PRIMARY KEY(idResultados)
);

CREATE TABLE Recibo (
  Folio INTEGER NOT NULL AUTO_INCREMENT,
  Importe FLOAT NULL,
  Fecha DATE NULL,
  Receptor_Nombre VARCHAR (100) NULL,
  Emisor_Nombre VARCHAR (100) NULL,
  RFC_Receptor VARCHAR (100) NULL,
  RFC_Emisor VARCHAR (100) NULL,
  Retenciones FLOAT NULL,
  Traslados FLOAT NULL,
  PRIMARY KEY(Folio)
);

CREATE TABLE Factura (
  Folio INTEGER NOT NULL AUTO_INCREMENT,
  Importe FLOAT NULL,
  Fecha DATE NULL,
  Receptor_Nombre VARCHAR (100) NULL,
  Emisor_Nombre VARCHAR (100) NULL,
  RFC_Receptor VARCHAR (100) NULL,
  RFC_Emisor VARCHAR (100) NULL,
  Traslados FLOAT NULL,
  PRIMARY KEY(Folio)
);


