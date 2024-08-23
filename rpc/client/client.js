const grpc = require('@grpc/grpc-js')
const protoLoder = require('@grpc/proto-loader')

const PROTO_FILE = './proto/user.proto'

const package_definition = protoLoder.loadSync(
    PROTO_FILE,
    {keepCase:true, longs:String, enums:String, arrays:true}
)

const user_proto = grpc.loadPackageDefinition(package_definition).UserService

const client = new user_proto(
    'localhost:3030',
    grpc.credentials.createInsecure()
)

module.exports = client