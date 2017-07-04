CREATE TABLE COLOR (
  CODIGO INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRIPCION VARCHAR(50) NOT NULL,
  RED INTEGER UNSIGNED NOT NULL,
  GREEN INTEGER UNSIGNED NOT NULL,
  BLUE INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(CODIGO)
);

INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('red',255,99,132);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('orange',255,159,64);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('yellow',255,205,86);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('green',75,192,192);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('blue',54,162,235);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('purple',153,102,255);
INSERT INTO COLOR (DESCRIPCION, RED, GREEN, BLUE) VALUES ('grey',201,203,207);

CREATE TABLE INDICADOR (
  CODIGO INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRIPCION VARCHAR(500) NULL,
  POSITION INTEGER UNSIGNED NULL,
  PADRE INTEGER UNSIGNED NULL,
  TIPO VARCHAR(20) NOT NULL DEFAULT 'folder',
  PUBLICO TINYINT(1) UNSIGNED DEFAULT 0,
  PRIMARY KEY(CODIGO),
  INDEX INDICADOR_PADRE_FK(PADRE),
  FOREIGN KEY(PADRE)
    REFERENCES INDICADOR(CODIGO)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

INSERT INTO INDICADOR (DESCRIPCION, TIPO, POSITION) VALUES ('Region Ica','root', 1);

CREATE TABLE GRAFICO (
  CODIGO INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  INDICADOR INTEGER UNSIGNED NOT NULL,
  TIPO VARCHAR(20) NOT NULL,
  PRIMARY KEY(CODIGO),
  INDEX GRAFICO_INDICADOR_FK(INDICADOR),
  FOREIGN KEY(INDICADOR)
    REFERENCES INDICADOR(CODIGO)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE DETALLE_GRAFICO (
  CODIGO INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRIPCION VARCHAR(500) NULL COMMENT 'Texto que se mostrará en el arbol',
  GRAFICO INTEGER UNSIGNED NULL COMMENT 'Codigo del grafico en caso estar lleno no debe tener padre',
  PADRE INTEGER UNSIGNED NULL COMMENT 'Codigo del grupo padre',
  VALOR DOUBLE NULL COMMENT 'Valor del indicador',
  TIPO VARCHAR(25) NULL DEFAULT 'bar' COMMENT 'Tipo de Indicador / bar o line',
  LABEL VARCHAR(500) NULL,
  BORDERCOLOR VARCHAR(25) NULL COMMENT 'Color de la linea o barra a mostrar',
  BORDERWIDTH INTEGER UNSIGNED NULL DEFAULT 2,
  PRIMARY KEY(CODIGO),
  INDEX DETALLE_GRAFICO_GRAFICO_FK(GRAFICO),
  INDEX DETALLE_GRAFICO_PADRE_FK(PADRE),
  FOREIGN KEY(GRAFICO)
    REFERENCES GRAFICO(CODIGO)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(PADRE)
    REFERENCES DETALLE_GRAFICO(CODIGO)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);