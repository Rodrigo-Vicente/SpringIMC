package imc.calcular.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IMC")
public class ImcController {

    private static final Double BadRequest = null;

    @GetMapping("/")
    public String Resultado(){
        Double peso = 50.0;
        Double altura = 1.72;

        Double Imc = CalcularIMC(peso, altura);
        String Value = StatusIMC(Imc);

        return ("O seu IMC é: "+ Imc + ", Classificado como " + Value);
    }
    
    private Double CalcularIMC(Double peso, Double altura){
       Boolean validar =  ValidateValues( peso,  altura);
        if(validar == true){
        Object imc = peso/(altura * altura );

         return (Double) imc;

        }else{
        return BadRequest;
        }
    }

    private Boolean ValidateValues(Double peso, Double altura){
        if(peso > 0 && altura >0){
            return true;
        }else{
            return false;
        }
    }
    private String StatusIMC(Double Imc){
        if(Imc <= 18.5){
            return ("Magreza");
        }else if(Imc > 18.5 && Imc <= 24.9){
            return ("Normal");
        }else if(Imc > 25 && Imc <= 29.9){
            return ("SOBREPESO");
        }else if(Imc > 30 && Imc <= 39.9){
            return ("OBESIDADE");
        }else{
            return ("OBESIDADE GRAVE");
        } 
    }
}
