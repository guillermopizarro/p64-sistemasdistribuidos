const model = require('./model')

async function insertar_usuario(dato) {
    const resultado = await new model(dato)
    return resultado.save()
}

async function obtener_usuario(dato) {
     let mi_filtro = {}
     
     if (dato.usuario != null) {
        mi_filtro = { usuario: dato.usuario }
     }

     const resultado = await model.find( mi_filtro )
     return resultado
}

async function actualizar_usuario(dato) {
    const usuario = await model.findOne( {usuario:dato.usuario} )
    usuario.nombre = dato.nombre
    usuario.apellido = dato.apellido
    usuario.clave = dato.clave
    usuario.fecha_nacimiento = dato.fecha_nacimiento

    const resultado = usuario.save()
    return resultado
}

async function eliminar_usuario(dato) {
    const resultado = await model.deleteOne( {usuario: dato.usuario} )
    return resultado
}

module.exports = {
    insertar:insertar_usuario,
    obtener:obtener_usuario,
    actualizar:actualizar_usuario,
    eliminar:eliminar_usuario
}