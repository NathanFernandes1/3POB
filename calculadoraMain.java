package br.edu.faeterj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		int op=0;
		double resultado=0;
		double var1=0;
		double var2=0;
		
		while(op!= 5) {
		System.out.println("Selecione a operacao:\n 1-Soma\n2-Subtracao\n3-Divisao\n4-Multiplicacao\n5- Sair");
		op = sc.nextInt();
		
		if(op!= 5) {
			System.out.println("Digite a primeira variavel: ");
			 var1 = sc.nextDouble();
			
			System.out.println("Digite a segunda variavel: ");
			 var2 = sc.nextDouble();
			
			 
			switch(op) {
			 case 1:
				 resultado= var1 + var2;
				 break;
			
			 case 2:
				 resultado= var1 - var2;
				 break;
			
			 case 3:
				 resultado= var1 / var2;
				 break;
			 
			 case 4:
				 resultado= var1 * var2;
				 break;
			}
			System.out.println("Valores digitados. var1: " + var1 +" var2: "+ var2);
			System.out.println("Resultado: " + resultado);
			
		}
		
		}
		/*int resultado = calc.Soma(var1, var2);
		System.out.println("Soma das variaveis: " + resultado);
		
		resultado = calc.Subtracao(var1, var2);
		System.out.println("Subtracao das variaveis: " + resultado);*/
	
	}
}
