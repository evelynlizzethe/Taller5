case class Estudiante(nombre: String, edad: Int)

val estudiantes = List (
  Estudiante("Daniel",23),
  Estudiante("Pablo", 21),
  Estudiante("Maria", 22),
  Estudiante("Daniela", 23)
)
def obtenerEdad(e: Estudiante): Int = e.edad

val mayor = estudiantes.maxBy(obtenerEdad)

def noDivide(n: Int, k: Int): Boolean = {
  n % k != 0
}

def isPrime(n: Int): Boolean = {
  def check(k: Int): Boolean = noDivide(n, k)
  (2 to n - 1).forall(check)
}
println(isPrime(7))


