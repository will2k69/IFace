# IFace

<p>CODE SMELLS IDENTIFICADOS</p>
<p></p>
<ul>
<li><ul>"Long Method"
<li>UserPage(inicio) [Pattern used]---> "Command"</li>
</ul></li>

<li><ul>"Lazy Class"
<li>UserPage e MainPageIface [Pattern used]--> "UserPage para de extender MainPageIface"</li>
</ul></li>

<li><ul>"Code Duplicated"
<li>UserPage(linha 97) [Pattern used]---> "Template e Extract Method"</li>
<li>Relacionamentos(linha 166, 128, 106) [Pattern used]---> "Template e Extract Method"</li>
<li>métodos AcessFeed, AcessCommunity, SendMessage, SendFriendship, ViewFriendRequest, ToListFriends, InfoAccount, ModifyAccount e DeleteAccount usavam 'keyboard' e 'login' [Pattern used]---> "Extract Class"</li>
</ul></li>

<li><ul>"Comments"
<li>Relacionamentos(linha 54, 57)</li>
</ul></li>

<li><ul>"Long Parameter List"
<li>AcessFeed(execute) [Pattern used]---> "Introduce Parameter Object"</li>
<li>AcessCommunity(execute) [Pattern used]---> "Introduce Parameter Object"</li>