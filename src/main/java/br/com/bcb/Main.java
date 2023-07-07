package br.com.bcb;

import br.com.bcb.utils.ManipulationFile;
import br.com.bcb.utils.Utils;

public class Main {
    public static void main(String[] args) {
        Utils util = new Utils();
        ManipulationFile file = new ManipulationFile();
        System.out.println("Bem-vindo ao Banco Central!");
        util.optionSelect();
    }
}

