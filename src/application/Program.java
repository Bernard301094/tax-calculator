/*
    Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
    podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
    bem como o total de imposto arrecadado.

    Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
    são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
    seguintes:

    Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
    renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
    destes gastos são abatidos no imposto.
    Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
    fica: (50000 * 25%) - (2000 * 50%) = 11500.00.

    Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
    funcionários, ela paga 14% de imposto.
    Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
    400000 * 14% = 56000.
*/

package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List <TaxPayer> taxPayers = new ArrayList<>();

        System.out.println("Enter the number of tax payers:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            sc.nextLine(); // Consume the newline character

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                taxPayers.add(new Individual(anualIncome, name, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(anualIncome, name, numberOfEmployees));
            }
        }

        System.out.println("\nTAXES PAID:");
        double totalTax = 0.0;
        for (TaxPayer taxPayer : taxPayers) {
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
            totalTax+= taxPayer.tax();
        }

        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", totalTax));
        sc.close();
    }
}
