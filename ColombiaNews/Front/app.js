// Función para leer el archivo JSON
async function leerArchivoJSON() {
    try {
        const rutaArchivo = "../noticias_colombia.json"; // Ruta al archivo JSON
        const response = await fetch(rutaArchivo);
        const data = await response.json();
        mostrarNoticiasEnHTML(data.articles);
    }
    catch (error) {
        console.error("Error al cargar el archivo JSON:", error);
    }
}

// Función para mostrar las noticias en el HTML
function mostrarNoticiasEnHTML(articles) {
    var noticiasLista = document.getElementById("noticias-lista");
    articles.forEach(function (noticia) {
        var titulo = noticia.title;
        var autor = noticia.author;
        var url = noticia.url;
        var fecha = noticia.publishedAt;
        var elementoLista = document.createElement("li");
        var elementoTitulo = document.createElement("p");
        var elementoAutor = document.createElement("p");
        var elementoEnlace = document.createElement("a");
        var elementoFecha = document.createElement("p");
        elementoTitulo.textContent = "Título: " + titulo;
        elementoAutor.textContent = "Medio: " + autor;
        elementoEnlace.textContent = url;
        elementoEnlace.setAttribute("href", url);
        elementoFecha.textContent = "Fecha: " + fecha;
        elementoLista.appendChild(elementoTitulo);
        elementoLista.appendChild(elementoAutor);
        elementoLista.appendChild(elementoEnlace);
        elementoLista.appendChild(elementoFecha);
        noticiasLista.appendChild(elementoLista);
    });
}

// Llama a la función para leer el archivo JSON y mostrar las noticias
leerArchivoJSON();