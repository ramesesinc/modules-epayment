[getUnpostedPaymentList]
SELECT p.*,
po.txntype, po.txntypename,
po.paidby, po.particulars, po.refno, po.origin,
po.mobileno, po.email, po.phoneno,
pp.code AS partnercode, pp.objid AS partnerid
FROM payment p 
INNER JOIN paymentorder po ON p.paymentrefid = po.objid
INNER JOIN payment_partner pp ON p.paypartnerid = pp.objid 
WHERE p.receiptid IS NULL AND p.orgcode = $P{orgcode}
