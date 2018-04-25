	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
            
            
  
<script type="text/javascript" charset="utf-8">        

</script>
 <div style="padding:10px 60px 20px 60px">  
     <form id="editRack" method="post">  
         <table cellpadding="10">  
          
             <tr>  
                 <td>货架名:</td>  
                 <td><input class="easyui-textbox" type="text" name="name" missingMessage="请填写货架名称" data-options="required:true"></input></td>  
             </tr>  
              <tr>                  
                 <td><input hidden="true"  type="text" name="id"  data-options="required:true"></input></td>  
             </tr>              
             <tr>  
                 <td>货架参数:</td>  
                <td><textarea name="parm"  rows="8" cols="24" data-options="required:true"></textarea></td>
             </tr>
            
         </table>  
     </form>  
    
 </div>  




