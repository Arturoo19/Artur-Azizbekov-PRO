import model.Administrador
import controller.Fantasy

fun main() {
    var admin = Administrador(1,"Artur",123)
    admin.autorizacion(admin.clave)
    var fantasy = Fantasy()

}