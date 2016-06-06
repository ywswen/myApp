
var x = 50, y = 60; //图片初始位置
var xin = true, yin = true;
var step = 1;
var delay = 10;
var obj = document.getElementById("www_qpsh_com");
function floatwww_qpsh_com() { 
	//图片活动范围 start
	var L = 0;     //左
	var T = 100;   //上
	var R = document.body.clientWidth - obj.offsetWidth;      //右
	var B = document.body.clientHeight - obj.offsetHeight;   //下
	//图片活动范围  end
	obj.style.left = x + document.body.scrollLeft;
	obj.style.top = y + document.body.scrollTop;
	x = x + step * (xin ? 1 : -1);
	if (x < L) {
		xin = true;
		x = L;
	}
	if (x > R) {
		xin = false;
		x = R;
	}
	y = y + step * (yin ? 1 : -1);
	if (y < T) {
		yin = true;
		y = T;
	}
	if (y > B) {
		yin = false;
		y = B;
	}
}
var itl = setInterval("floatwww_qpsh_com()", delay);
obj.onmouseover = function () {
	clearInterval(itl);
};
obj.onmouseout = function () {
	itl = setInterval("floatwww_qpsh_com()", delay);
};

