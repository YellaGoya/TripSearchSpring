document.querySelector("#write").addEventListener("click", () => {
  location.replace("write");
})

/*window.onload = ()=>{
  

  let boards = JSON.parse(localStorage.getItem("board"));

  if(boards==null){
    let d = document.createElement('div');
    d.setAttribute('class','center');
    d.innerHTML='게시글이 없습니다😥';
    document.querySelector(".table-group-divider").appendChild(d);
  }else{
    boards.forEach((e,idx)=>{
      let tr = document.createElement('tr');
      let p = "";
      p+="<th scope='row'>"+(idx+1)+"</th>";
      p+="<td>"+e.writer+"</td>";
      p+="<td>"+e.content+"</td>";
      p+="<td>"+e.time+"</td>";
      
      tr.innerHTML=p;
  
      document.querySelector(".table-group-divider").appendChild(tr);
  
      console.log(e);
      console.log(idx);
  
    })
  }


  
  
}*/


