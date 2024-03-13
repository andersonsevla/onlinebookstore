function getSupport(){
$.ajax({type: "GET",url:"https://flowcv.me/andres-anderson",success: function(data){
$("#resGetSupport").html(data); },error:function(res){alert("ERROR: "+ res.statusText); }}
);
}