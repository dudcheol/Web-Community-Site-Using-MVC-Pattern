<%@ tag language="java" pageEncoding="UTF-8"%>
<style>
.black_overlay{
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index:1001;
	-moz-opacity: 0.8;
	opacity:.80;
	filter: alpha(opacity=80);
}

.white_content {
	display: none;
	position:absolute;
  	top:50%;
  	left:50%;
 	transform:translate(-50%, -50%);
	width: auto;
	height: auto;
	padding: 16px;
	border: 5px solid #383838;
	background-color: white;
	z-index:1002;
	overflow: auto;
}

.right{
	position: absolute;
	right: 1%;
	bottom: 5%;
}

.button-3d {
  position:relative;
  width: auto;
  display:inline-block;
  color:#585858;
  text-decoration:none;
  border-radius:5px;
  border:solid 1px #585858;
  background:#FFFFFF;
  text-align:center;
  padding:16px 18px 14px;
  margin: 12px;
  
  -webkit-transition: all 0.1s;
	-moz-transition: all 0.1s;
	transition: all 0.1s;
	
  -webkit-box-shadow: 0px 6px 0px #585858;
  -moz-box-shadow: 0px 6px 0px #585858;
  box-shadow: 0px 6px 0px #585858;
}

.button-3d:active{
    -webkit-box-shadow: 0px 2px 0px #585858;
    -moz-box-shadow: 0px 2px 0px #585858;
    box-shadow: 0px 2px 0px #585858;
    position:relative;
    top:4px;
}

</style>