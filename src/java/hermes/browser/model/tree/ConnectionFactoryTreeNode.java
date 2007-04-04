/* 
 * Copyright 2003,2004 Colin Crist
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

package hermes.browser.model.tree;


import hermes.browser.IconCache;

import javax.jms.ConnectionFactory;

/**
 * @author colincrist@hermesjms.com last changed by: $Author: colincrist $
 * @version $Id: ConnectionFactoryTreeNode.java,v 1.4 2005/05/24 12:58:17 colincrist Exp $
 */
public class ConnectionFactoryTreeNode extends AbstractTreeNode
{  
    /**
     * @param id
     * @param icon
     */
    public ConnectionFactoryTreeNode(String id, ConnectionFactory connectionFactory)
    {
        super(id, connectionFactory);
        
        setIcon(IconCache.getIcon("jms.connectionFactory")) ;
    }
}
