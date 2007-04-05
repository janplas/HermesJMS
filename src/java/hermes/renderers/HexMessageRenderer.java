/* 
 * Copyright 2003,2004,2005 Colin Crist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package hermes.renderers;

import hermes.browser.ConfigDialogProxy;
import hermes.browser.MessageRenderer;
import hermes.swing.MyTextArea;
import hermes.util.DumpUtils;
import hermes.util.MessageUtils;

import java.awt.Font;

import javax.jms.Message;
import javax.swing.JComponent;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * A renderer that converts the message into hex for viewing.
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: HexMessageRenderer.java,v 1.3 2007/02/18 16:13:41 colincrist Exp $
 */

public class HexMessageRenderer implements MessageRenderer
{
   private static final Logger log = Logger.getLogger(HexMessageRenderer.class);

   public HexMessageRenderer()
   {
      super();
      
   }

   public JComponent render(Message m)
   {
      final JTextArea textArea = new MyTextArea();

      textArea.setEditable(false);     
      textArea.setFont(Font.decode("Monospaced-PLAIN-12")) ;
      
      byte[] bytes = null;

      try
      {
         bytes = MessageUtils.asBytes(m);
         textArea.setText(DumpUtils.dumpBinary(bytes, DumpUtils.DUMP_AS_HEX_AND_ALPHA));
      }
      catch (Throwable e)
      {
         textArea.setText(e.getMessage());
         
         log.error("exception converting message to byte[]: ", e);
      }

      textArea.setCaretPosition(0);

      return textArea ;
   }

   /**
    * There are no configurable options on this renderer.
    */
   public Config createConfig()
   {
      return null;
   }

   /**
    * There are no configurable options on this renderer
    */
   public void setConfig(Config config)
   {
      // TODO Auto-generated method stub
   }

   /**
    * There are no configurable options on this renderer
    */
   public JComponent getConfigPanel(ConfigDialogProxy dialogProxy) throws Exception
   {
      return null;
   }

   /**
    * Any JMS message is rederable.
    */
   public boolean canRender(Message message)
   {
      return true;
   }

   public String getDisplayName()
   {
      return "Hex";
   }
   
   public Config getConfig()
   {
      return null ;
   }
   
  
}