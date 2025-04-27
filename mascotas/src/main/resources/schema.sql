CREATE TABLE propietario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nac DATE,
    raza VARCHAR(100),
    peso DOUBLE,
    tiene_chip BOOLEAN,
    url_foto VARCHAR(500),
    propietario_id BIGINT,
    CONSTRAINT fk_mascota_propietario FOREIGN KEY (propietario_id) REFERENCES propietario(id)
);
