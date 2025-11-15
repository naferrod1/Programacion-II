class NumeroInvalidoException(Exception):
    pass


class Calculadora:

    @staticmethod
    def sumar(a, b):
        return a + b

    @staticmethod
    def restar(a, b):
        return a - b

    @staticmethod
    def multiplicar(a, b):
        return a * b

    @staticmethod
    def dividir(a, b):
        if b == 0:
            raise ZeroDivisionError("No se puede dividir entre cero.")
        return a / b

    @staticmethod
    def convertir_numero(texto):
        try:
            return float(texto)
        except ValueError:
            raise NumeroInvalidoException("El valor ingresado no es numérico.")
            

def main():
    print("=== PRUEBAS DE CALCULADORA ===")

    try:
        n1 = Calculadora.convertir_numero("12")
        n2 = Calculadora.convertir_numero("4")
        print("Suma:", Calculadora.sumar(n1, n2))
    except Exception as e:
        print("Error:", e)

    try:
        Calculadora.convertir_numero("abc")
    except Exception as e:
        print("Error esperado:", e)

    try:
        Calculadora.dividir(10, 0)
    except Exception as e:
        print("Error esperado:", e)


if __name__ == "__main__":
    main()
