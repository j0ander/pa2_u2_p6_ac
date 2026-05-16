INSERT INTO estudiante (
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
);