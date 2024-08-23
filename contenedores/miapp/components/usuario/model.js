const mongoose = require('mongoose')
const schema = mongoose.Schema

const req_string = {
    type: String,
    required: true
}

const req_date = {
    type: Date,
    required: true
}

const usuario_schema = new schema({
    usuario: req_string,
    clave: req_string,
    nombre: req_string,
    apellido: req_string,
    fecha_nacimiento: req_date,
    fecha_registro: Date,
    fecha_actualizacion: Date
}, {
    timestamps: { createdAt: 'fecha_creacion', updatedAt: 'fecha_actualizacion' }
})

const model = mongoose.model('Usuario', usuario_schema)
module.exports = model