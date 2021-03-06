[getPartners]
select distinct partnerid as id
from payment_partner_option

[getTxnCounts]
select 
	pp.orgcode,
	p.paypartnerid,
	count(*) as value
from paymentorder_paid pp 
inner join payment p on pp.objid = p.paymentrefid
where p.txndate >= $P{fromdate} and p.txndate < $P{todate}
group by pp.orgcode, paypartnerid

[getTxnAmounts]
select 
	pp.orgcode,
	p.paypartnerid,
	sum(pp.amount) as value
from paymentorder_paid pp 
inner join payment p on pp.objid = p.paymentrefid
where p.txndate >= $P{fromdate} and p.txndate < $P{todate}
group by pp.orgcode, paypartnerid

[getTotalTxnCounts]
select 
	p.paypartnerid,
	count(*) as total
from paymentorder_paid pp 
inner join payment p on pp.objid = p.paymentrefid
where p.txndate >= $P{fromdate} and p.txndate < $P{todate}
and pp.orgcode <> '000'
group by paypartnerid

[getTotalTxnAmounts]
select 
	p.paypartnerid,
	sum(pp.amount) as total
from paymentorder_paid pp 
inner join payment p on pp.objid = p.paymentrefid
where p.txndate >= $P{fromdate} and p.txndate < $P{todate}
and pp.orgcode <> '000'
group by paypartnerid

[findYearRange]
select 
	min(year(txndate)) as minyear, 
	max(year(txndate)) as maxyear 
from paymentorder_paid

