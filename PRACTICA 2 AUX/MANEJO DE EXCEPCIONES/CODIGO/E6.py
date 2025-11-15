class FondosInsuficientesException(Exception):
    pass


class CuentaBancaria:
    def __init__(self, numeroCuenta, titular, saldo):
        self.numeroCuenta = numeroCuenta
        self.titular = titular
        self.saldo = saldo

    def depositar(self, monto):
        if monto <= 0:
            raise ValueError("El monto debe ser positivo.")
        self.saldo += monto
        print(f"Depósito exitoso. Nuevo saldo: {self.saldo}")

    def retirar(self, monto):
        if monto <= 0:
            raise ValueError("El monto debe ser positivo.")
        if monto > self.saldo:
            raise FondosInsuficientesException("Fondos insuficientes.")
        self.saldo -= monto
        print(f"Retiro exitoso. Nuevo saldo: {self.saldo}")


def main():
    print("=== PRUEBAS DE CUENTA BANCARIA ===")

    cuenta = CuentaBancaria("12345", "Juan Pérez", 1000)

    try:
        cuenta.depositar(500)
    except Exception as e:
        print("Error:", e)


    try:
        cuenta.depositar(-200)
    except Exception as e:
        print("Error esperado:", e)


    try:
        cuenta.retirar(300)
    except Exception as e:
        print("Error:", e)

   
    try:
        cuenta.retirar(5000)
    except Exception as e:
        print("Error esperado:", e)


if __name__ == "__main__":
    main()