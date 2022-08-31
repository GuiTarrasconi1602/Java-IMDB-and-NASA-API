package imersao_java_1;


import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
	

	public static void main(String[] args) throws Exception {
		// Realizando a conexao
		//String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";	
		
		 String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		 //ExtractorNasa extractor = new ExtractorNasa();
		 ExtractorIMDB extractor = new ExtractorIMDB();
		 
		
		var http = new ClientHttp();
		String json = http.buscaDados(url);
		
		
		List<Conteudo> conteudos = extractor.extractContent(json);
		
		var stickerGenerator = new StickerGenerator();
			
		for (int i=0; i < 3; i++) {
			 Conteudo content = conteudos.get(i);

	            InputStream inputStream = new URL(content.getUrlImagem()).openStream();
	            String nameFile = "output/" + content.getTitulo() + ".png";

	            stickerGenerator.createSticker(inputStream, nameFile);

	            System.out.println(content.getTitulo());
	            System.out.println();
			
			
		}
			//double notafilmedouble = Double.parseDouble(conteudo.get("imDbRating"));
			//int notafilme = (int) notafilmedouble;
			//for(int i =0; i<notafilme; i++) {
				//System.out.print("★");	
			//}
			//System.out.println(" ("+ conteudo.get("imDbRating")+")");
			
			
		}
	
	
	}

