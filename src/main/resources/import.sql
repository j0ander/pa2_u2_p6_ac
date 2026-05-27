/* INSERT INTO estudiante (
    estu_id,
    estu_nombre,
    estu_apellido,
    estu_fecha_nacimiento,
    estu_genero
) VALUES (
    nextval('seq_estudiante'),
    'Anderson',
    'Chancusi',
    '2005-01-29',
    'Masculino'
);, */
INSERT INTO profesor (
    prof_id,
    prof_nombre,
    prof_apellido,
    prof_cedula,
    prof_materia
) VALUES (
    nextval('seq_profesor'),
    'Anderson',
    'Chancusi',
    '012345678',
    'Base de Datos'
);