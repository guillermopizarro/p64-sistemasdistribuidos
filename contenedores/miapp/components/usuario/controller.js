const storage = require('./storage')

function insertar_usuario( dato ) {
    return new Promise( (resolve, reject) => {
        if (!dato.usuario || !dato.clave || !dato.nombre || !dato.apellido || !dato.fecha_nacimiento ) {
            reject( 'Los datos se encuentran incompletos.' )
        } else {
            resolve( storage.insertar( dato ) )
        }
    } )
}

function obtener_usuario( dato ) {
    return new Promise( (resolve, reject) => {
        if (!dato) {
            reject( 'No existen datos' )
        } else {
            resolve( storage.obtener( dato ) )
        }
    } )
}

function actualizar_usuario(dato) {
    return new Promise( (resolve, reject) => {
        if (!dato.usuario || !dato.clave || !dato.nombre || !dato.apellido || !dato.fecha_nacimiento ) {
            reject( 'Los datos se encuentran incompletos.' )
        } else {
            let usuario = {
                nombre: dato.nombre,
                apellido: dato.apellido,
                usuario: dato.usuario,
                clave: dato.clave,
                fecha_nacimiento: dato.fecha_nacimiento
            }
            resolve( storage.actualizar( usuario ) )
        }
    } ) 
}

function eliminar_usuario(dato) {
    return new Promise( (resolve, reject) => {
        if ( !dato.usuario ) {
            reject( 'Los datos se encuentran incompletos.' )
        } else {
            resolve( storage.eliminar( dato ) )
        }
    } ) 
}

module.exports = {
    insertar_usuario,
    obtener_usuario,
    actualizar_usuario,
    eliminar_usuario
}