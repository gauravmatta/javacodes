package javaimplant.argumentprocessing;

import java.io.File;

import com.google.gwt.util.tools.ArgHandlerDir;
import com.google.gwt.util.tools.ArgHandlerInt;
import com.google.gwt.util.tools.ToolBase;

public class MyProgramHandler extends ToolBase {

	protected File dir;
	protected int port;
	
	public File getDir() {
		return dir;
	}
	public void setDir(File dir) {
		this.dir = dir;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public MyProgramHandler() 
	{
		this.registerHandler(new ArgHandlerDir() {
			
				@Override
				public void setDir(File dir) 
				{
					this.dir = dir;
				}
		
				@Override
				public String getPurpose() {
					// TODO Auto-generated method stub
					return null;
				}
		
				@Override
				public String getTag() {
					// TODO Auto-generated method stub
					return null;
				}		
		});
		
		
		this.registerHandler(new ArgHandlerInt() {
		
			@Override
			public String[] getTagArgs() {
					return new String[]{"port"};
			}
			
			@Override
			public void setInt(int value) {
				this.port = value;
			}
			
			@Override
			public String getPurpose() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getTag() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
		
	public static void main(String[] args) 
	{
		MyProgramHandler myShell = new MyProgramHandler();
		if (myShell.processArgs(args)) 
		{
			// main program operation
			System.out.println(String.format("port: %d; dir: %s",myShell.getPort(), myShell.getDir()));
		}
		System.exit(1);
	}
}