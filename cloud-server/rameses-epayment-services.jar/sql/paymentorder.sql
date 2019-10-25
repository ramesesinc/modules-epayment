[movePaymentOrderToPaid]
INSERT INTO paymentorder_paid SELECT * FROM paymentorder WHERE objid=$P{paymentrefid}
