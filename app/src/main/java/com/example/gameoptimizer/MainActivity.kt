package com.example.gameoptimizer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import rikka.shizuku.Shizuku

class MainActivity : AppCompatActivity() {

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        val checkButton: Button = findViewById(R.id.checkButton)
        val optimizeButton: Button = findViewById(R.id.optimizeButton)

        checkButton.setOnClickListener {
            if (Shizuku.pingBinder()) {
                statusText.text = "Shizuku подключен. Можно применять оптимизации."
            } else {
                statusText.text = "Shizuku недоступен. Запусти Shizuku и выдай разрешение приложению."
            }
        }

        optimizeButton.setOnClickListener {
            applyOptimizations()
        }
    }

    private fun applyOptimizations() {
        if (!Shizuku.pingBinder()) {
            statusText.text = "Сначала активируй Shizuku."
            return
        }

        val commands = listOf(
            "cmd power set-fixed-performance-mode-enabled true",
            "settings put global window_animation_scale 0.5",
            "settings put global transition_animation_scale 0.5",
            "settings put global animator_duration_scale 0.5"
        )

        val result = StringBuilder("Команды оптимизации:\n")
        commands.forEach { command ->
            result.append("• ").append(command).append('\n')
        }

        statusText.text = "Оптимизации готовы. Ниже список команд для запуска через Shizuku shell:\n\n$result"
    }
}
