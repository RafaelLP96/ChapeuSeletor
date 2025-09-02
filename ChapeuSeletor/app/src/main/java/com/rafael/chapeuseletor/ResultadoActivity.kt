package com.rafael.chapeuseletor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // 1. Pegar as referências das Views da tela de resultado
        val textResultado = findViewById<TextView>(R.id.textResultado)
        val imageBrasao = findViewById<ImageView>(R.id.imageBrasao)

        // 2. Receber o nome da casa que foi enviado pela MainActivity
        val nomeCasa = intent.getStringExtra("EXTRA_CASA_NOME")

        // 3. Exibir o texto com o nome da casa
        textResultado.text = "Você pertence à... $nomeCasa!"

        // 4. Definir a imagem do brasão com base no nome da casa
        val idImagem = when (nomeCasa) {
            "Grifinória" -> R.drawable.brasao_grifinoria // Use os nomes exatos dos seus arquivos!
            "Corvinal" -> R.drawable.brasao_corvinal
            "Sonserina" -> R.drawable.brasao_sonserina
            "Lufa-Lufa" -> R.drawable.brasao_lufalufa
            else -> 0 // Um valor padrão caso algo dê errado
        }

        // 5. Se o ID da imagem for válido, exibi-la
        if (idImagem != 0) {
            imageBrasao.setImageResource(idImagem)
        }
    }
}