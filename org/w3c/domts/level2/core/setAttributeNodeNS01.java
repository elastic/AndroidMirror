
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2004 World Wide Web Consortium, 
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All 
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the 
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
PURPOSE.  

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;

import org.w3c.dom.*;


import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *     The "setAttributeNode(newAttr)" method raises an 
 *    "INUSE_ATTRIBUTE_ERR DOMException if the "newAttr" 
 *    is already an attribute of another element.
 *    
 *    Retrieve the first emp:address and append
 *    a newly created element.  The "createAttributeNS(namespaceURI,qualifiedName)"
 *    and "setAttributeNodeNS(newAttr)" methods are invoked
 *    to create and add a new attribute to the newly created
 *    Element.  The "setAttributeNodeNS(newAttr)" method is
 *    once again called to add the new attribute causing an
 *    exception to be raised since the attribute is already
 *    an attribute of another element.
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-258A00AF')/constant[@name='INUSE_ATTRIBUTE_ERR'])</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-ElSetAtNodeNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-ElSetAtNodeNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INUSE_ATTRIBUTE_ERR'])</a>
*/
public final class setAttributeNodeNS01 extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public setAttributeNodeNS01(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {
      super(factory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staffNS", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      String namespaceURI = "http://www.newattr.com";
      String qualifiedName = "emp:newAttr";
      Document doc;
      Element newElement;
      Attr newAttr;
      NodeList elementList;
      Node testAddr;
      Node appendedChild;
      Attr setAttr1;
      Attr setAttr2;
      doc = (Document) load("staffNS", true);
      elementList = doc.getElementsByTagName("emp:address");
      testAddr = elementList.item(0);
      assertNotNull("empAddrNotNull", testAddr);
      newElement = doc.createElement("newElement");
      appendedChild = testAddr.appendChild(newElement);
      newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
      setAttr1 = newElement.setAttributeNodeNS(newAttr);
      
      {
         boolean success = false;
         try {
            setAttr2 = ((Element) /*Node */testAddr).setAttributeNodeNS(newAttr);
          } catch (DOMException ex) {
            success = (ex.code == DOMException.INUSE_ATTRIBUTE_ERR);
         }
         assertTrue("throw_INUSE_ATTRIBUTE_ERR", success);
      }
}
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/setAttributeNodeNS01";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(setAttributeNodeNS01.class, args);
   }
}

