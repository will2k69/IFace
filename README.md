# IFace

<p>CODE SMELLS IDENTIFICADOS</p>
<p></p>
<ul>
<li><ul>"Long Method"
  <li>UserPage(inicio) (Pattern)-> "Command"</li><li>Relacionamentos(sendMessage, sendMessageMyFeed, sendMessageFeed)</li></ul></li>
<li><ul>"Lazy Class"
<li>UserPage</li>
<li>MainPageIface</li>
</ul></li>
<li><ul>"Long Parameter List"
  <li>Relacionamentos(sendMessage, sendMessageFeed, solicitarAmizade) (Pattern)-> "Template e Extract Method"</li>
  </ul>
<li><ul>"Code Duplicated"
<li>UserPage(linha 97) (Pattern)-> "Template e Extract Method"</li>
<li>Relacionamentos(linha 166, 128, 106) (Pattern)-> "Template e Extract Method"</li>
</ul>
<li><ul>"Comments"
<li>Relacionamentos(linha 54, 57)