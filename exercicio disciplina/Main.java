package br.com.escola20241;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
    	String nome = "";
        String sigla = "";
        String cargaHoraria = "";
        String semestre = "";
        
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome("Projeto de banco de dados");
        disciplina.setSigla("PBD");
        disciplina.setCargaHoraria("120");
        disciplina.setSemestre("3");
        
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Sigla: " + disciplina.getSigla());
        System.out.println("Carga Horaria: " + disciplina.getCargaHoraria());
        System.out.println("Semestre: " + disciplina.getSemestre());
   
    }

}
