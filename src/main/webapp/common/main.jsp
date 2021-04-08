<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="card-body" style="text-align: center;">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<tbody>
											<%-- <form id="frm" action="${cp}/BoardInfoAdd" method="get"> --%>
											<tr>
												<th>ê²ìí ì´ë¦</th>
												<th><input type="text" id="bor_name" placeholder="ìì ê²ìí"></th>
												<th><select class="form-control col-md-7" name="searchType" id="bor_act">
														<option value="1">ì¬ì©</option>
														<option value="0">ë¯¸ì¬ì©</option>
													</select>
												</th>
												<th><input type="button"  class="btn btn-primary"  id="insertBtn" value="ìì±"/></th>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
						</div>
						<c:forEach items="${boardList }" var="board">
							 <form id="frm" action="${cp}/boardInfoUpdate" method="get"> 
									<input type="hidden" name="bor_no2" value="${board.bor_no }"/>
								<div  class="col-sm-7" >
								<label> &nbsp;&nbsp;&nbsp;&nbsp;ê²ìí ì´ë¦ &nbsp;&nbsp;&nbsp;  </label> &nbsp;&nbsp;&nbsp;<input value="${board.bor_name }" readonly>
									<c:choose>
										<c:when test="${board.bor_act ==1 }">
											
												<select class=" col-md-2" name="bor_act"  id="board.bor_act">
													<option value="1" selected="selected">ì¬ì©</option>
													<option value="0">ë¯¸ì¬ì©</option>
												</select>
											
										</c:when>
										<c:otherwise>
											
												<select class=" col-md-2" name="bor_act" id="board.bor_act" >
													<option value="1">ì¬ì©</option>
													<option value="0"  selected="selected">ë¯¸ì¬ì©</option>
												</select>
											
										</c:otherwise>
									</c:choose>
									<input type="submit" id="updateBtn" value="ìì "/>
								</div>
							</form>
						</c:forEach>
						
						<!-- card-body -->