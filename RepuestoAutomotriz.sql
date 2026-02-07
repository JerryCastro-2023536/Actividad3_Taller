Drop database if exists DBRepuestosAutomotriz_in5cm;
create database DBRepuestosAutomotriz_in5cm;
use DBRepuestosAutomotriz_in5cm; 

create table Proveedores(
	id_proveedor int auto_increment not null,
	nombre_proveedor varchar(60) not null,
	telefono_proveedor int not null,
	direccion varchar(100) not null,
	email_proveedor varchar(100) not null,
	primary key PK_id_proveedor(id_proveedor)
);

create table Empleados(
	id_empleado int auto_increment not null,
	nombre_empleado varchar(60) not null,
	apellido_empleado varchar(60) not null,
	puesto_empleado varchar(20) null,
	email_empleado varchar(100) not null,
	primary key PK_id_empleado(id_empleado)
);

create table Repuestos(
	id_repuesto int auto_increment not null,
	nombre_repuesto varchar(60) not null,
	categoria_repuesto varchar(60) not null,
	precio_compra double not null,
	precio_venta double not null,
	id_proveedor int not null,
	primary key PK_id_repuesto(id_repuesto),
	constraint FK_repuesto_proveedor foreign key (id_proveedor)
	references proveedores(id_proveedor) on delete cascade
);

create table Ventas(
	id_venta int auto_increment not null,
	fecha_venta date not null,
	cantidad int not null,
	total double not null,
	id_empleado int not null,
	id_repuesto int not null,
	primary key PK_id_venta(id_venta),
	constraint FK_ventas_empleado foreign key (id_empleado)
	references Empleados(id_empleado) on delete cascade,
	constraint FK_ventas_repuestos foreign key (id_repuesto)
	references Repuestos(id_repuesto) on delete cascade
);

-- PROCEDIMIENTOS ALMACENADOS

-- EMPLEADOS
delimiter $$
	create procedure sp_agregar_empleado(
		in p_nombre varchar(60),
        in p_apellido varchar(60),
        in p_puesto varchar(10),
        in p_email varchar(100)
    )
    begin
		insert into Empleados(nombre_empleado, apellido_empleado, puesto_empleado, email_empleado)
        values (p_nombre, p_apellido, p_puesto, p_email);
    end $$
delimiter ;

delimiter $$
	create procedure sp_listar_empleado()
    begin
		select * from Empleados;
    end $$
delimiter ;

delimiter $$
	create procedure sp_buscar_empleado(in p_id int)
    begin
		select * from Empleados where id_empleado = p_id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_actualizar_empleado(
		in p_id int, 
        in p_nombre varchar(60),
        in p_apellido varchar(60),
        in p_puesto varchar(10),
        in p_email varchar(100)
    )
    begin 
		update Empleados e set e.nombre_empleado = p_nombre, e.apellido_empleado = p_apellido,
        e.puesto_empleado = p_puesto, e.email_empleado = p_email where e.id_empleado = p_id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_eliminar_empleado(in p_id int)
    begin
		delete from Empleados where id_empleado = p_id;
    end $$
delimiter ;

-- PROVEEDORES

delimiter $$ 
	create procedure sp_agregar_proveedor(
		in p_nombre varchar(60),
		in p_telefono int,
		in p_direccion varchar(100),
		in p_email varchar(100)
	)
	begin
		insert into Proveedores(nombre_proveedor, telefono_proveedor, direccion, email_proveedor)
		values (p_nombre, p_telefono, p_direccion, p_email);
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_listar_proveedores()
	begin
		select * from Proveedores;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_buscar_proveedores(in p_id int)
	begin
		select * from Proveedores where id_proveedor = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_actualizar_proveedor(
		in p_id int,
		in p_nombre varchar(60),
		in p_telefono int,
		in p_direccion varchar(100),
		in p_email varchar(100)
	)
	begin
		update Proveedores p
		set p.nombre_proveedor = p_nombre, p.telefono_proveedor = p_telefono, p.direccion = p_direccion, 
		p.email_proveedor = p_email where p.id_proveedor = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_eliminar_proveedor(in p_id int)
	begin
		delete from Proveedores where id_proveedor = p_id;
	end $$ 
delimiter ;

-- REPUESTOS

delimiter $$ 
	create procedure sp_agregar_repuesto(
		in p_nombre varchar(60),
		in p_categoria varchar(60),
		in p_precio_compra double,
		in p_precio_venta double,
		in p_id_proveedor int
	)
	begin
		insert into Repuestos(nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor)
		values (p_nombre, p_categoria, p_precio_compra, p_precio_venta, p_id_proveedor);
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_listar_repuestos()
	begin
		select * from Repuestos;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_buscar_repuestos(in p_id int)
	begin
		select * from Repuestos where id_repuesto = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_actualizar_repuesto(
		in p_id int,
		in p_nombre varchar(60),
		in p_categoria varchar(60),
		in p_precio_compra double,
		in p_precio_venta double,
		in p_id_proveedor int
	)
	begin
		update Repuestos r set r.nombre_repuesto = p_nombre, r.categoria_repuesto = p_categoria,
			r.precio_compra = p_precio_compra, r.precio_venta = p_precio_venta, 
            r.id_proveedor = p_id_proveedor where r.id_repuesto = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_eliminar_repuesto(in p_id int)
	begin
		delete from Repuestos where id_repuesto = p_id;
	end $$ 
delimiter ;

-- VENTAS

delimiter $$ 
	create procedure sp_agregar_venta(
		in p_fecha date,
		in p_cantidad int,
		in p_total double,
		in p_id_empleado int,
		in p_id_repuesto int
	)
	begin
		insert into Ventas(fecha_venta, cantidad, total, id_empleado, id_repuesto)
		values (p_fecha, p_cantidad, p_total, p_id_empleado, p_id_repuesto);
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_listar_ventas()
	begin
		select * from Ventas;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_buscar_ventas(in p_id int)
	begin
		select * from Ventas where id_venta = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_actualizar_venta(
		in p_id int,
		in p_fecha date,
		in p_cantidad int,
		in p_total double,
		in p_id_empleado int,
		in p_id_repuesto int
	)
	begin
		update Ventas v
		set v.fecha_venta = p_fecha, v.cantidad = p_cantidad, v.total = p_total,
			v.id_empleado = p_id_empleado, v.id_repuesto = p_id_repuesto where v.id_venta = p_id;
	end $$ 
delimiter ;

delimiter $$ 
	create procedure sp_eliminar_venta(in p_id int)
	begin
		delete from Ventas where id_venta = p_id;
	end $$ 
delimiter ;

-- DATOS POR DEFECTO

call sp_agregar_proveedor('AutoPartes GT', 55510101, 'Zona 1, Ciudad', 'ventas@autopartesgt.com');
call sp_agregar_proveedor('Motores del Norte', 55510202, 'Zona 5, Ciudad', 'contacto@motoresnorte.com');
call sp_agregar_proveedor('Repuestos Express', 55510303, 'Zona 7, Ciudad', 'info@repuestosexpress.com');
call sp_agregar_proveedor('Importadora El Pistón', 55510404, 'Zona 9, Ciudad', 'ventas@elpiston.com');
call sp_agregar_proveedor('Distribuidora Torque', 55510505, 'Zona 10, Ciudad', 'soporte@torque.com');
call sp_agregar_proveedor('Mega Repuestos', 55510606, 'Zona 11, Ciudad', 'mega@repuestos.com');
call sp_agregar_proveedor('AutoSuministros', 55510707, 'Zona 12, Ciudad', 'autosum@correo.com');
call sp_agregar_proveedor('Repuestos La 20', 55510808, 'Zona 3, Ciudad', 'la20@repuestos.com');
call sp_agregar_proveedor('Partes Premium', 55510909, 'Zona 14, Ciudad', 'premium@partes.com');
call sp_agregar_proveedor('AutoGlobal', 55511010, 'Zona 15, Ciudad', 'global@auto.com');


call sp_agregar_empleado('Carlos','Ramirez','Vendedor','carlos@empresa.com');
call sp_agregar_empleado('Ana','Lopez','Cajero','ana@empresa.com');
call sp_agregar_empleado('Luis','Martinez','Bodega','luis@empresa.com');
call sp_agregar_empleado('Maria','Gomez','Vendedor','maria@empresa.com');
call sp_agregar_empleado('Jorge','Castillo','Supervisor','jorge@empresa.com');
call sp_agregar_empleado('Sofia','Hernandez','Cajero','sofia@empresa.com');
call sp_agregar_empleado('Pedro','Mendez','Bodega','pedro@empresa.com');
call sp_agregar_empleado('Laura','Vasquez','Vendedor','laura@empresa.com');
call sp_agregar_empleado('Diego','Morales','Supervisor','diego@empresa.com');
call sp_agregar_empleado('Elena','Rojas','Cajero','elena@empresa.com');


call sp_agregar_repuesto('Filtro de aceite','Motor',25,40,1);
call sp_agregar_repuesto('Pastillas de freno','Frenos',30,55,2);
call sp_agregar_repuesto('Bujía NGK','Encendido',10,20,3);
call sp_agregar_repuesto('Batería 12V','Eléctrico',60,95,4);
call sp_agregar_repuesto('Aceite 20W50','Lubricantes',18,30,5);
call sp_agregar_repuesto('Radiador Toyota','Refrigeración',120,180,6);
call sp_agregar_repuesto('Amortiguador','Suspensión',75,120,7);
call sp_agregar_repuesto('Alternador','Eléctrico',150,220,8);
call sp_agregar_repuesto('Correa de tiempo','Motor',35,60,9);
call sp_agregar_repuesto('Disco de freno','Frenos',45,80,10);


call sp_agregar_venta('2026-01-01',2,80,1,1);
call sp_agregar_venta('2026-01-02',1,55,2,2);
call sp_agregar_venta('2026-01-03',4,80,3,3);
call sp_agregar_venta('2026-01-04',1,95,4,4);
call sp_agregar_venta('2026-01-05',3,90,5,5);
call sp_agregar_venta('2026-01-06',1,180,6,6);
call sp_agregar_venta('2026-01-07',2,240,7,7);
call sp_agregar_venta('2026-01-08',1,220,8,8);
call sp_agregar_venta('2026-01-09',2,120,9,9);
call sp_agregar_venta('2026-01-10',1,80,10,10);

