CREATE TABLE Recibo_Factura (
  idRecibo_Factura INTEGER NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY(idRecibo_Factura)
);

CREATE TABLE Usuario (
  idUsuario INTEGER NOT NULL ,
  RFC VARCHAR (100) NOT NULL,
  PRIMARY KEY(idUsuario)
);
