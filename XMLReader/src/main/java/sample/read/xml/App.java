package sample.read.xml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedWriter;

import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    // public static final Path INPUT_FILE = Paths.get(System.getProperty("user.dir") , "src" , "main" , "resources" , "input.xml"); 
    // public static final Path OUTPUT_FILE = Paths.get(System.getProperty("user.dir") , "src" , "main" , "resources" , "output.tsv"); 
    // public static final Path ATTRIBUTE_LIST_FILE = Paths.get(System.getProperty("user.dir") , "src" , "main" , "resources" , "attribute.lst"); 

    public static void main( String[] args ) {
        int argsIndex = 0;
        Path inputPath = Paths.get(args[argsIndex++]);
        Path outputPath = Paths.get(args[argsIndex++]);
        Path attributeListPath = Paths.get(args[argsIndex++]);
        
        System.out.println(String.format("INPUT:%s",inputPath));
        System.out.println(String.format("OUTPUT:%s",outputPath));
        System.out.println(String.format("ATTRIBUTE_LIST:%s",attributeListPath));
        
        try {
            // list読み込み
            List<String> attributeList = Files.readAllLines(attributeListPath, StandardCharsets.UTF_8);
            
            DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
    
            File f = new File( inputPath.toString() );
            Document doc = builder.parse( f );
            Element root = doc.getDocumentElement();
            NodeList children = root.getChildNodes();

            try(BufferedWriter writer = Files.newBufferedWriter(outputPath)) { 
                writer.write("tag\t");
                for(String attribute : attributeList){
                    writer.write(attribute + "\t");
                }
                writer.write(System.lineSeparator());

                for( int i=0; i<children.getLength(); i++ ) {
                    Node child = children.item(i);
                       
                    if( child instanceof Element ) {
                        Element childElement = (Element) child;
                        writer.write( childElement.getTagName() + "\t" );
                        for( String attribute : attributeList ) {
                            writer.write( childElement.getAttribute(attribute) + "\t" );
                        }
                        writer.write(System.lineSeparator());
                    }
                }
            } catch ( IOException e ) {
                throw e;
            }
        } catch( ParserConfigurationException | SAXException | IOException e ) {
            e.printStackTrace();
        }
    }
}
