/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
  var jfk = $(".jfk-bubble"); 
  $("#name").focus(function(){
    jfk.addClass("active");
  }).blur(function(){
    jfk.removeClass("active");
  });
});