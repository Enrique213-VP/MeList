# 🛒 Melist - Catálogo de Productos en Línea

**Melist** es una aplicación móvil desarrollada en Android con **Jetpack Compose**, diseñada para ofrecer una experiencia de exploración de productos rápida, moderna y eficiente. Inspirada en plataformas de e-commerce reales, esta app permite buscar artículos, visualizar resultados detallados y navegar entre categorías seleccionadas.

> 🚨 Actualmente, las búsquedas están limitadas a términos específicos:  
**zapatos, camisas, partes de carros y iPhone.**

---

## ✨ Características principales

- 🔎 Búsqueda de productos en línea.
- 🖼 Visualización atractiva de cada producto (imagen, nombre, precio).
- 💬 Interacción fluida y moderna gracias a Jetpack Compose.
- 🧠 Arquitectura limpia usando **MVVM**.
- ⚙️ Inyección de dependencias con **Hilt**.
- 📦 Consumo de API REST para obtener los productos.

---

## 🧱 Arquitectura del proyecto

```
Presentation (UI - Jetpack Compose)
│
├── ViewModel (Controla lógica de presentación)
│
├── UseCase (Lógica de negocio)
│
├── Repository (Intermediario entre capa de datos y dominio)
│
└── Data (Fuentes de datos: API, DTOs, Mappers)
```

- **MVVM** (Model - View - ViewModel)
- Estados de UI con `sealed class` y `StateFlow`
- Navegación con `Navigation Compose`

---

## 🧰 Tecnologías utilizadas

| Herramienta      | Descripción                                    |
|------------------|------------------------------------------------|
| **Kotlin**       | Lenguaje base de la app                        |
| **Jetpack Compose** | UI declarativa moderna                      |
| **Hilt**         | Inyección de dependencias                      |
| **Retrofit**     | Cliente HTTP para APIs REST                    |
| **Coroutines**   | Manejo de asincronía                           |
| **StateFlow**    | Manejo reactivo del estado de la UI           |
| **Navigation**   | Navegación entre pantallas                     |
| **ViewModel**    | Lógica de presentación desacoplada            |

---

## 🚀 Cómo ejecutar la app

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/melist.git
   ```
2. Abre el proyecto en **Android Studio** (recomendado: versión Arctic Fox o superior).
3. Conecta un dispositivo físico o ejecuta un emulador.
4. Haz clic en **Run** ▶️ y explora la app.

---

## 🔎 Términos de búsqueda permitidos

Por ahora, la app permite realizar búsquedas únicamente de los siguientes productos:

- 👟 Zapatos  
- 👕 Camisas  
- 🚗 Partes de carros  
- 📱 iPhone  

Esto se hace para garantizar resultados válidos en esta versión inicial.

---

## 🧑‍💻 Autor

**Sergio Vargas**  

📱 _Desarrollador Android y multiplataforma_
