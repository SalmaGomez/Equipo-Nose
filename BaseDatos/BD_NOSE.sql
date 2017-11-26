CREATE TABLE Resultados (
  idResultados INTEGER NOT NULL AUTO_INCREMENT,
  Impuestos FLOAT NULL,
  Ganancias FLOAT NULL,
  Perdidas FLOAT NULL,
  Utilidad_Bruta FLOAT NULL,
  Fecha DATE NULL UNIQUE,
  PRIMARY KEY(idResultados)
);

CREATE TABLE Recibo_Factura (
  Folio INTEGER NOT NULL,
  Importe FLOAT NULL,
  Fecha DATE NULL ,
  Receptor_Nombre VARCHAR (100) NULL,
  Emisor_Nombre VARCHAR (100) NULL,
  RFC_Receptor VARCHAR (100) NULL,
  RFC_Emisor VARCHAR (100) NULL,
  Tipo VARCHAR (100) NOT NULL,
  Impuesto FLOAT NULL,
  Metodo_Pago VARCHAR (100) NOT NULL,
  PRIMARY KEY(Folio)
);

CREATE TABLE Usuario (
  idUsuario INTEGER NOT NULL ,
  RFC VARCHAR (100) NOT NULL,
  PRIMARY KEY(idUsuario)
);
