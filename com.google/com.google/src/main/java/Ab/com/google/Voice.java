package Ab.com.google;
import com.sun.speech.freetts.VoiceManager;

public class Voice 
{
	private String name;

	private com.sun.speech.freetts.Voice voice;
	public Voice(String name)
	{
		this.name= name;
		this.voice=VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();

	}
	public void say (String something)
	{
		this.voice.speak(something);
	}
	public void sayMultiple(String[] sayMePls){
		for(int i=0;i< sayMePls.length;i++){
			this.say(sayMePls[i]);
			
		}
		
	}


}

