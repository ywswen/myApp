/**
 * 获取cookie，例如name：admin
 * @date 2014-5-10 15:50:30
 * @param name
 * @return
 */
function getCookie( name ) { 
    var start = document.cookie.indexOf( name + "=" ); 
    var len = start + name.length + 1; 
    if ( ( !start ) && ( name != document.cookie.substring( 0, name.length ) ) ) { 
        return null; 
    } 
    if ( start == -1 ) return null; 
    var end = document.cookie.indexOf( ';', len ); 
    if ( end == -1 ) end = document.cookie.length; 
    return unescape( document.cookie.substring( len, end ) ); 
} 
 
/**
 * 设置cookie，参数expires, path, domain, secure可以设置为空
 * @date  2014-5-10 15:51:16
 * @param name
 * @param value
 * @param expires date类型
 * @param path
 * @param domain
 * @param secure
 * @return
 */
function setCookie( name, value, expires, path, domain, secure ) { 
    var today = new Date(); 
    today.setTime( today.getTime() ); 
    if ( expires ) { 
        expires = expires * 1000 * 60 * 60 * 24; 
    } 
    var expires_date = new Date( today.getTime() + (expires) ); 
    document.cookie = name+'='+escape( value ) + 
        ( ( expires ) ? ';expires='+expires_date.toGMTString() : '' ) + //expires.toGMTString() 
        ( ( path ) ? ';path=' + path : '' ) + 
        ( ( domain ) ? ';domain=' + domain : '' ) + 
        ( ( secure ) ? ';secure' : '' ); 
} 
 
/**
 * 删除cookie
 * @date  2014-5-10 15:52:29
 * @param name
 * @param path
 * @param domain
 * @return
 */
function deleteCookie( name, path, domain ) { 
    if ( getCookie( name ) ) document.cookie = name + '=' + 
            ( ( path ) ? ';path=' + path : '') + 
            ( ( domain ) ? ';domain=' + domain : '' ) + 
            ';expires=Thu, 01-Jan-1970 00:00:01 GMT'; 
} 
/**
 * 读取cookie
 * @return
 */
function readCookie() { 
    var keepUser = getCookie("keepUser");
    if(keepUser=="1"){
	    document.getElementById("keepUser").checked=true;
	    var username = getCookie("username");
	    document.getElementById("username").value=username;
	    var keepPassword = getCookie("keepPassword");
	    if(keepPassword=="1"){
		    document.getElementById("keepPassword").checked=true;
		    var password = getCookie("password");
		    document.getElementById("password").value=password==null?"":password;
	    }
    }
} 
/**
 * 初始化用户名和密码cookie
 * @date  2014-5-10 15:53:17
 * @return
 */
function initCookie() { 
    var keepPassword = getCookie("keepPassword");
    if(keepPassword=="1"){
	    var username = getCookie("username");
		var password = getCookie("password");
	    document.getElementById("username").value=username==null?"":username;
		document.getElementById("password").value=password==null?"":password;
    }
} 
/**
 * 初始化密码cookie
 * @date  2014-5-10 15:53:35
 * @return
 */
function initPasswordCookie() { 
    var keepPassword = getCookie("keepPassword");
    if(keepPassword=="1"){
	    var cookidName = getCookie("username");
	    var userName = document.getElementById("username").value;
	    if(cookidName == userName){
		    var password = getCookie("password");
		    document.getElementById("password").value=password==null?"":password;
	    }
    }
} 