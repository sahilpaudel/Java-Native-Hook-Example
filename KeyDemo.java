
// Library Import for JavaNativeHook library for listening to key strokes.
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyDemo implements NativeKeyListener{
    
	String keyText = "";
	int keyCode = 0;
    public KeyDemo(){
		  
    }
	// Overrided Method for KeyEvent i.e., when users Presses a key.
    public void nativeKeyPressed(NativeKeyEvent e) {

    	// Get the KeyCode and KeyText of the particular key that user has Pressed.   	
		keyText = e.getKeyText(e.getKeyCode());
			System.out.println("\nPRESSED KEY : "+keyText);
	}
	public void nativeKeyTyped(NativeKeyEvent e){}
	public void nativeKeyReleased(NativeKeyEvent e){
		
		// Get the KeyCode and KeyText of the particular key that user has Released.  
		keyText = e.getKeyText(e.getKeyCode());
			System.out.println("\nRELEASED KEY : "+keyText);
	}
	 
	public static void main(String[] args){
		// Register the NativeHook with the GlobalScreen.
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
        	// Do Nothing.
        }

        // Add NativeKeyListener to GlobalScreen.
		GlobalScreen.addNativeKeyListener(new KeyDemo());	
	}
}
