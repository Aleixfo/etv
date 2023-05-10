-- Crear la enumeración para los tipos de número de identificación
CREATE TYPE tipo_identificacion_enum AS ENUM ('DNI', 'NIF', 'Pasaporte', 'Cédula', 'Otro');

-- Crear la tabla para los usuarios registrados
CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(100) NOT NULL,
  contraseña VARCHAR(100) NOT NULL,
  id_poblacion INT,
  num_reservas INT DEFAULT 0,
  num_comentarios INT DEFAULT 0,
  valoracion_dueño DECIMAL(4, 2) DEFAULT 0,
  telefono VARCHAR(20),
  descripcion TEXT,
  num_identificacion VARCHAR(50),
  tipo_identificacion tipo_identificacion_enum,
  fecha_registro DATE,
  verificado BOOLEAN DEFAULT false,
  FOREIGN KEY (id_poblacion) REFERENCES poblacion(id)
);

-- Crear la tabla para los países
CREATE TABLE paises (
  codigo_pais CHAR(3) PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  id_divisa INT,
  FOREIGN KEY (id_divisa) REFERENCES divisas(id)
);

-- Crear la tabla para las provincias
CREATE TABLE provincias (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  codigo_pais CHAR(3),
  FOREIGN KEY (codigo_pais) REFERENCES paises(codigo_pais)
);

-- Crear la tabla para las poblaciones
CREATE TABLE poblacion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  id_provincia INT,
  FOREIGN KEY (id_provincia) REFERENCES provincias(id)
);

-- Crear la tabla para las divisas
CREATE TABLE divisas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  simbolo VARCHAR(10) NOT NULL,
  tasa_cambio DECIMAL(10, 4) NOT NULL,
  valor_divisa_euros DECIMAL(10, 4) NOT NULL
);

-- Crear la tabla para las características de la propiedad (casas)
CREATE TABLE caracteristica_propiedad (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  descripcion TEXT,
  capacidad INT,
  ubicacion VARCHAR(100),
  precio DECIMAL(10, 2),
  caracteristica_activa BOOLEAN DEFAULT true
);

-- Crear la tabla para las reservas
CREATE TABLE reservas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_caracteristica_propiedad INT,
  id_usuario INT,
  id_divisa INT,
  id_tarifa INT,
  fecha_inicio DATE,
  fecha_fin DATE,
  precio_total DECIMAL(10, 2),
  descuento DECIMAL(10, 2),
  precio_total_descuento DECIMAL(10, 2),
  observaciones TEXT,
  aprobada BOOLEAN DEFAULT false,
  FOREIGN KEY (id_caracteristica_propiedad) REFERENCES caracteristica_propiedad(id),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (id_divisa) REFERENCES divisas(id),
  FOREIGN KEY (id_tarifa) REFERENCES tarifas(id)
);

-- Crear la tabla para las tarifas
CREATE TABLE tarifas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre_tarifa VARCHAR(100) NOT NULL,
  porcentaje_tarificacion DECIMAL(5, 2) NOT NULL,
  descripcion TEXT,
  fecha_inicio DATE,
  fecha_fin DATE,
  tarifa_activa BOOLEAN DEFAULT true
);

-- Crear la tabla para las reservas canceladas
CREATE TABLE reservas_canceladas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_reserva INT,
  motivo TEXT,
  FOREIGN KEY (id_reserva) REFERENCES reservas(id)

-- Crear la tabla para los comentarios de los clientes
CREATE TABLE comentarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  comentario TEXT
  calificacion INT NOT NULL,
  fecha_comentario DATE NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)