insert into usuario values (1, '07-41896', 'estudiante');
insert into usuario values (2, 'zchiquin', 'profesor');
insert into usuario values (3, '05-37862', 'estudiante');
insert into usuario values (4, '06-40073', 'estudiante');
insert into usuario values (5, 'cctds', 'cctds');
insert into usuario values (6, 'coord-comp', 'coordinacion');
insert into usuario values (7, 'sabad', 'profesor');
insert into usuario values (8, '06-12345', 'estudiante');
insert into usuario values (9, '07-00000', 'estudiante');
insert into usuario values (10, '06-00000', 'estudiante');
insert into usuario values (11, '05-00000', 'estudiante');
insert into usuario values (12, 'aalonso', 'profesor');
insert into usuario values (13, 'kdominguez', 'profesor');

insert into carrera values (1, 'Ingeniería Eléctrica', 'coord-ee@usb.ve');
insert into carrera values (2, 'Ingeniería de Computación', 'coord-comp@usb.ve');
insert into carrera values (3, 'Ingeniería Mecánica', 'coord-mec@usb.ve');
insert into carrera values (4, 'Ingeniería Eléctronica', 'coord-electronica@usb.ve');
insert into carrera values (5, 'Ingeniería Química', 'coord-iq@usb.ve');
insert into carrera values (6, 'Ingeniería de Producción', 'coord-prod@usb.ve');
insert into carrera values (7, 'Urbanismo', 'coord-urb@usb.ve');

insert into departamento values (1, 'Computación y Tecnología de la Información');
insert into departamento values (2, 'Procesos y Sistemas');
insert into departamento values (3, 'Física');
insert into departamento values (4, 'Química');
insert into departamento values (5, 'Computo Científico y Estadística');
insert into departamento values (6, 'Electrónica y Circuitos');

insert into area values (1, 'Bases de Datos');
insert into area values (2, 'Lenguajes y Algoritmos');
insert into area values (3, 'Inteligencia Artificial');
insert into area values (4, 'Sistemas Paralelos y Distribuidos');
insert into area values (5, 'Gráficas, Interfaces y Multimedia');
insert into area values (6, 'Procesos Químicos');
insert into area values (7, 'Sistemas de Información');
insert into area values (8, 'Sistemas de Control');

insert into departamentoarea values (1, 1, 1);
insert into departamentoarea values (2, 2, 1);
insert into departamentoarea values (3, 3, 1);
insert into departamentoarea values (4, 4, 1);
insert into departamentoarea values (5, 5, 1);
insert into departamentoarea values (6, 6, 2);
insert into departamentoarea values (7, 7, 2);
insert into departamentoarea values (8, 8, 2);

insert into pais values (1, 'Argentina');
insert into pais values (2, 'Brasil');
insert into pais values (3, 'España');
insert into pais values (4, 'Portugal');
insert into pais values (5, 'Venezuela');

insert into ciudad values (1, 'Brasilia',2);
insert into ciudad values (2, 'Buenos Aires',1);
insert into ciudad values (3, 'Caracas',5);
insert into ciudad values (4, 'Lisboa',4);
insert into ciudad values (5, 'Madrid',3);
insert into ciudad values (6, 'Maracaibo',5);
insert into ciudad values (7, 'Puerto Ordaz',5);
insert into ciudad values (8, 'Rio de Janeiro',2);

insert into estatuspasantia values (1, 'Aprobado');
insert into estatuspasantia values (2, 'Retirado');
insert into estatuspasantia values (3, 'Reprobado');
insert into estatuspasantia values (4, 'Rezagado');
insert into estatuspasantia values (5, 'Revisado');
insert into estatuspasantia values (6, 'Por revisar');
insert into estatuspasantia values (7, 'Pasar por CCTDS');

insert into estatusprorroga values (1, 'Aprobada');
insert into estatusprorroga values (2, 'Por revisar');
insert into estatusprorroga values (3, 'Pasar por coordinación');
insert into estatusprorroga values (4, 'Rechazada');

insert into periodopasantiaintermedia values (1, 'Enero-Marzo');
insert into periodopasantiaintermedia values (2, 'Abril-Julio');
insert into periodopasantiaintermedia values (3, 'Septiembre-Diciembre');
insert into periodopasantiaintermedia values (4, 'Octubre-Febrero');

insert into periodopasantialarga values (1, 'Enero-Mayo');
insert into periodopasantialarga values (2, 'Abril-Septiembre');
insert into periodopasantialarga values (3, 'Julio-Diciembre');
insert into periodopasantialarga values (4, 'Octubre-Febrero');

insert into trimestre values (1,'Septiembre-Diciembre');
insert into trimestre values (2,'Enero-Marzo');
insert into trimestre values (3,'Abril-Julio');

